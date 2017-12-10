package com.mcapp.practice.jasperreports.batch;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@RunWith(PowerMockRunner.class)
public class JasperreportsBatchPracticeTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@PrepareForTest({ JasperreportsBatchPractice.class })
	public void testMainWhenAllCasesExecuteReportGenerate() {
		// arrange
		String[] args = null;

		JasperViewer mockJasperViewer = mock(JasperViewer.class);

		try {
			whenNew(JasperViewer.class).withArguments(isNotNull(JasperPrint.class)).thenReturn(mockJasperViewer);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		doNothing().when(mockJasperViewer).setVisible(true);

		// action
		try {
			JasperreportsBatchPractice.main(args);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception should not throw");
		}

		// assert
		verify(mockJasperViewer, times(1)).setVisible(true);
	}
}
