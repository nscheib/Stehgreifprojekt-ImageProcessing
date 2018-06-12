package Filter;

import java.awt.image.BufferedImage;


public interface IFilter {

    BufferedImage process(BufferedImage... image);

}
