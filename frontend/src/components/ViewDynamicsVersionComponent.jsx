import React, { Component } from 'react'
import DynamicsVersionService from '../services/DynamicsVersionService'

class ViewDynamicsVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dynamicsVersion: {}
        }
    }

    componentDidMount(){
        DynamicsVersionService.getDynamicsVersionById(this.state.id).then( res => {
            this.setState({dynamicsVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DynamicsVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseUML:&emsp; </label>
                            <div> { this.state.dynamicsVersion.baseUML }</div>
                        </div>
                        <div className = "row">
                            <label> baseURI:&emsp; </label>
                            <div> { this.state.dynamicsVersion.baseURI }</div>
                        </div>
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.dynamicsVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> differenceModelURI:&emsp; </label>
                            <div> { this.state.dynamicsVersion.differenceModelURI }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeUML:&emsp; </label>
                            <div> { this.state.dynamicsVersion.entsoeUML }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURI:&emsp; </label>
                            <div> { this.state.dynamicsVersion.entsoeURI }</div>
                        </div>
                        <div className = "row">
                            <label> modelDescriptionURI:&emsp; </label>
                            <div> { this.state.dynamicsVersion.modelDescriptionURI }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceRDF:&emsp; </label>
                            <div> { this.state.dynamicsVersion.namespaceRDF }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceUML:&emsp; </label>
                            <div> { this.state.dynamicsVersion.namespaceUML }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.dynamicsVersion.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDynamicsVersionComponent
