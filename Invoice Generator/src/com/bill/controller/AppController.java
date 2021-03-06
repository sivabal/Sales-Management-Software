package com.bill.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.bill.dao.GetConnection;
import com.bill.dao.ToDatabase;
import com.bill.exception.InvalidPasswordException;
import com.bill.popus.ShowPopups;
import com.bill.utility.Utility;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class AppController implements Initializable {
	
	@FXML private Label dbStatus;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			GetConnection getConnection = new GetConnection();
			getConnection.getConnection();
			dbStatus.setText(((GetConnection.connection.isClosed())?"Disconnected":"Connected"));
			new Utility().getDetailsReady();
		} catch (SQLException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void printInvoice(ActionEvent event) {		
		
		try {
			
			Stage stage = new Stage();
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.getIcons().add(new Image("/icon.png"));
			stage.setTitle("Invoice");
			
			Parent parent = FXMLLoader.load(getClass().getResource("/invoice.fxml"));
			Scene scene = new Scene(parent);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	  }

	@FXML
	public void generateExcel(ActionEvent event) {
		
		try {
			
			Stage stage = new Stage();
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.getIcons().add(new Image("/icon.png"));
			stage.setTitle("Generate Excel");
			
			Parent parent = FXMLLoader.load(getClass().getResource("/excel.fxml"));
			Scene scene = new Scene(parent);
			
			
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void editProductDetails() {
		
		try {
			
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Edit Product Details");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/editproductdetails.fxml"));
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void editfromaddress() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Edit 'Bill From' Address");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/editfromaddress.fxml"));
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void edittoaddress() {
		try {
			if(ShowPopups.passwordPopUp()) {
				
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Edit 'Bill To' Address");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/edittoaddress.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void deleteInvoice() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Delete Invoice");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/deleteinvoice.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void inventory() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Inventory");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/inventory.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void goodsProduced() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Goods Produced");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/goodsproduced.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void salesMade() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Sales Made");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/salesmade.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void salesReturn() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Sales Return");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/salesreturn.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void stocks() {
		try {
			if(ShowPopups.passwordPopUp()) {
				Stage stage = new Stage();
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.getIcons().add(new Image("/icon.png"));
				stage.setTitle("Stock Info");
				
				Parent parent = FXMLLoader.load(getClass().getResource("/stock.fxml"));
				
				Scene scene = new Scene(parent);
				
				stage.setScene(scene);
				stage.show();
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
	
	@FXML
	public void changePassword() {
		try {
			if(ShowPopups.passwordPopUp()) {
				
				String newPassword = ShowPopups.getValue("New Password", "Please Enter New Password");
				
				if(newPassword != null) {
					ToDatabase.updatePassword(newPassword);
					Utility.password = newPassword;
					ShowPopups.showPopups(AlertType.INFORMATION, "Password Updated Successfully.", "");
				}
			
			}
		} catch (IOException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}catch (InvalidPasswordException e) {
			ShowPopups.showPopups(AlertType.ERROR, e.getMessage(), "");
		}catch (Exception e) {
			ShowPopups.showPopups(AlertType.ERROR, e.toString(), "");
		}
	}
}