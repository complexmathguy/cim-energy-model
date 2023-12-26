import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService'

class ViewBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            boundaryExtensions: {}
        }
    }

    componentDidMount(){
        BoundaryExtensionsService.getBoundaryExtensionsById(this.state.id).then( res => {
            this.setState({boundaryExtensions: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BoundaryExtensions Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> boundaryPoint:&emsp; </label>
                            <div> { this.state.boundaryExtensions.boundaryPoint }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndIsoCode:&emsp; </label>
                            <div> { this.state.boundaryExtensions.fromEndIsoCode }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndName:&emsp; </label>
                            <div> { this.state.boundaryExtensions.fromEndName }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndNameTso:&emsp; </label>
                            <div> { this.state.boundaryExtensions.fromEndNameTso }</div>
                        </div>
                        <div className = "row">
                            <label> toEndIsoCode:&emsp; </label>
                            <div> { this.state.boundaryExtensions.toEndIsoCode }</div>
                        </div>
                        <div className = "row">
                            <label> toEndName:&emsp; </label>
                            <div> { this.state.boundaryExtensions.toEndName }</div>
                        </div>
                        <div className = "row">
                            <label> toEndNameTso:&emsp; </label>
                            <div> { this.state.boundaryExtensions.toEndNameTso }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBoundaryExtensionsComponent
