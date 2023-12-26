import React, { Component } from 'react'
import EquipmentBoundaryVersionService from '../services/EquipmentBoundaryVersionService'

class ViewEquipmentBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equipmentBoundaryVersion: {}
        }
    }

    componentDidMount(){
        EquipmentBoundaryVersionService.getEquipmentBoundaryVersionById(this.state.id).then( res => {
            this.setState({equipmentBoundaryVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquipmentBoundaryVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseUML:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.baseUML }</div>
                        </div>
                        <div className = "row">
                            <label> baseURI:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.baseURI }</div>
                        </div>
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> differenceModelURI:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.differenceModelURI }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeUML:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.entsoeUML }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURIcore:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.entsoeURIcore }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURIoperation:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.entsoeURIoperation }</div>
                        </div>
                        <div className = "row">
                            <label> modelDescriptionURI:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.modelDescriptionURI }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceRDF:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.namespaceRDF }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceUML:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.namespaceUML }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.equipmentBoundaryVersion.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquipmentBoundaryVersionComponent
