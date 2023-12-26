import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService'

class ViewConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            connectivityNode: {}
        }
    }

    componentDidMount(){
        ConnectivityNodeService.getConnectivityNodeById(this.state.id).then( res => {
            this.setState({connectivityNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConnectivityNode Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> boundaryPoint:&emsp; </label>
                            <div> { this.state.connectivityNode.boundaryPoint }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndIsoCode:&emsp; </label>
                            <div> { this.state.connectivityNode.fromEndIsoCode }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndName:&emsp; </label>
                            <div> { this.state.connectivityNode.fromEndName }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndNameTso:&emsp; </label>
                            <div> { this.state.connectivityNode.fromEndNameTso }</div>
                        </div>
                        <div className = "row">
                            <label> toEndIsoCode:&emsp; </label>
                            <div> { this.state.connectivityNode.toEndIsoCode }</div>
                        </div>
                        <div className = "row">
                            <label> toEndName:&emsp; </label>
                            <div> { this.state.connectivityNode.toEndName }</div>
                        </div>
                        <div className = "row">
                            <label> toEndNameTso:&emsp; </label>
                            <div> { this.state.connectivityNode.toEndNameTso }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConnectivityNodeComponent
