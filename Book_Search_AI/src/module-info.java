module Example3 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires json;
	requires org.slf4j;
	requires org.apache.httpcomponents.httpclient;
	requires org.apache.httpcomponents.httpcore;
	requires gson;
	requires ch.qos.logback.classic;
	requires ch.qos.logback.core;
	requires junit;
	requires service;
	requires java.sql;
	requires java.sql.rowset;
	requires java.desktop;	
	opens kr.search.bproject to javafx.graphics, javafx.fxml;
}
