import React, { Component } from 'react'
import TopologicalNodeService from '../services/TopologicalNodeService'

class ViewTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            topologicalNode: {}
        }
    }

    componentDidMount(){
        TopologicalNodeService.getTopologicalNodeById(this.state.id).then( res => {
            this.setState({topologicalNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TopologicalNode Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> boundaryPoint:&emsp; </label>
                            <div> { this.state.topologicalNode.boundaryPoint }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndIsoCode:&emsp; </label>
                            <div> { this.state.topologicalNode.fromEndIsoCode }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndName:&emsp; </label>
                            <div> { this.state.topologicalNode.fromEndName }</div>
                        </div>
                        <div className = "row">
                            <label> fromEndNameTso:&emsp; </label>
                            <div> { this.state.topologicalNode.fromEndNameTso }</div>
                        </div>
                        <div className = "row">
                            <label> toEndIsoCode:&emsp; </label>
                            <div> { this.state.topologicalNode.toEndIsoCode }</div>
                        </div>
                        <div className = "row">
                            <label> toEndName:&emsp; </label>
                            <div> { this.state.topologicalNode.toEndName }</div>
                        </div>
                        <div className = "row">
                            <label> toEndNameTso:&emsp; </label>
                            <div> { this.state.topologicalNode.toEndNameTso }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTopologicalNodeComponent
