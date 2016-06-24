package Services;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import DBLayer.BrandDAO;
import DBLayer.GlassesDAO;
import DBLayer.Globals;
import Model.Brand;
import Model.Glasses;


@Path("/admin")
public class AdminServices {
	@POST
	@Path("/addNewGlasses")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String addNewGlasses(@Context ServletContext context, @Context HttpServletRequest request){
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(500000);
		FileUpload upload = new FileUpload(factory);
		Map<String, String> fields = new HashMap<String, String>();
		try {
			List<FileItem> items = upload.parseRequest(request);
			FileItem file = null;
			for(FileItem item : items){
				if(item.isFormField()){
					fields.put(item.getFieldName(), item.getString());
				}
				else{
					file = item;
				}
			}
			if(file == null){
				return Globals.FILE_PROBLEM;
			}
			else{
				String color = fields.get("color");
				String modelName = fields.get("modelName");
				int convertable = Integer.parseInt(fields.get("convertable"));
				String brandName = fields.get("brand");
				String shape = fields.get("shape");
				int type = Integer.parseInt(fields.get("type"));
				String material = fields.get("material");
				double price = Double.parseDouble(fields.get("price"));
				Brand brand = BrandDAO.getBrandByName(brandName);
				if(brand == null){
					return Globals.BRAND_NOT_EXIST;
				}
				if(GlassesDAO.getGlassesByModelName(modelName) == null){
					String firstPathPart = context.getRealPath("") + File.separator;
					String secondPathPart = "Glasses"
							+ File.separator + brandName + File.separator + file.getName();
					FileUtilities.saveFile(firstPathPart + secondPathPart, file.getInputStream());
					Glasses glasses = new Glasses(color, modelName, secondPathPart, convertable, shape, type, material, price, brand);
					GlassesDAO.addGlasses(glasses);
					return Globals.SUCCESS;
				}
				else{
					return Globals.ALREADY_EXIST;
				}
			}
		} catch (Exception e) {
			return Globals.FILE_PROBLEM;
		}
	}

	@Path("/addNewBrand")
	@POST
	public String addNewBrand(@FormParam("brandName") String brandName, 
			@FormParam("country") String country){
		Brand brand = new Brand(brandName, country);
		return BrandDAO.addBrand(brand) ? Globals.SUCCESS : Globals.ALREADY_EXIST;
	}
}
