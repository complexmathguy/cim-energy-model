import React, { Component } from 'react'
import MenuRouter from "./MenuRouterComponent";

const header = () => {
  return (
    <div className="container-fluid ">
      <div className="row">
        <div className="col-md-12">
          <MenuRouter className="dashbordmenu" />
        </div>
      </div>
    </div>
  );
};

export default header
