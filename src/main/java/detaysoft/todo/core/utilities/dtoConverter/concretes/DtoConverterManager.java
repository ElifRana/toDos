package detaysoft.todo.core.utilities.dtoConverter.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import detaysoft.todo.core.utilities.dtoConverter.abstracts.DtoConverterService;

@Service
public class DtoConverterManager implements DtoConverterService{

	private ModelMapper modelMapper;

    @Autowired
    public DtoConverterManager(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    
    public DtoConverterManager() {
    	
    }
    
    //Listelemede
    @Override
    public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass){
        return s.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());

    }

    //Eklemede
    @Override
    public <T> Object dtoClassConverter(Object source,Class<T> baseClass) {
        return modelMapper.map(source,baseClass);
    }
 
}
