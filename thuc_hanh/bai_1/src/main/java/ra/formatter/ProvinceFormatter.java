package ra.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ra.model.Province;
import ra.service.province.IProvinceService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
	private IProvinceService provinceService;
	
	@Autowired
	public ProvinceFormatter(Object provinceFormatter) {
		this.provinceService = (IProvinceService) provinceFormatter;
	}
	
	@Override
	public Province parse(String text, Locale locale) throws ParseException {
		Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
		return provinceOptional.orElse(null);
	}
	
	@Override
	public String print(Province object, Locale locale) {
		return "[" + object.getId() + ", " +object.getName() + "]";
	}
}
