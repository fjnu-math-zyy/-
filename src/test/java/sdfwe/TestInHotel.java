package sdfwe;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import com.fjnu.hotel.IData;
import com.fjnu.hotel.InHotel;

public class TestInHotel {

	private Mockery context = new Mockery();
	private IData iData = null;
	private InHotel ih = null;
	
	@Before
	public void setUp() throws Exception {
		iData = context.mock(IData.class);
		ih = new InHotel(iData);
		context.checking(new Expectations() {{
			atLeast(1).of(iData).in_Out_Room(901, "Mary");
			will(onConsecutiveCalls(returnValue("Marry成功入住901房间！"),
					returnValue("该房间已经有人入住！")));
		}});
	}
	
	@Test
	public void testIn() {
		assertEquals("Marry成功入住901房间！", ih.in(901, "Mary"));
		assertEquals("该房间已经有人入住！", ih.in(901, "Mary"));
	}

}
