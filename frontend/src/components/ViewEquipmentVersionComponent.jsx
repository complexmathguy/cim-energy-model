import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService'

class ViewEquipmentVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equipmentVersion: {}
        }
    }

    componentDidMount(){
        EquipmentVersionService.getEquipmentVersionById(this.state.id).then( res => {
            this.setState({equipmentVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquipmentVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseUML:&emsp; </label>
                            <div> { this.state.equipmentVersion.baseUML }</div>
                        </div>
                        <div className = "row">
                            <label> baseURIcore:&emsp; </label>
                            <div> { this.state.equipmentVersion.baseURIcore }</div>
                        </div>
                        <div className = "row">
                            <label> baseURIoperation:&emsp; </label>
                            <div> { this.state.equipmentVersion.baseURIoperation }</div>
                        </div>
                        <div className = "row">
                            <label> baseURIshortCircuit:&emsp; </label>
                            <div> { this.state.equipmentVersion.baseURIshortCircuit }</div>
                        </div>
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.equipmentVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> differenceModelURI:&emsp; </label>
                            <div> { this.state.equipmentVersion.differenceModelURI }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeUML:&emsp; </label>
                            <div> { this.state.equipmentVersion.entsoeUML }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURIcore:&emsp; </label>
                            <div> { this.state.equipmentVersion.entsoeURIcore }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURIoperation:&emsp; </label>
                            <div> { this.state.equipmentVersion.entsoeURIoperation }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURIshortCircuit:&emsp; </label>
                            <div> { this.state.equipmentVersion.entsoeURIshortCircuit }</div>
                        </div>
                        <div className = "row">
                            <label> modelDescriptionURI:&emsp; </label>
                            <div> { this.state.equipmentVersion.modelDescriptionURI }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceRDF:&emsp; </label>
                            <div> { this.state.equipmentVersion.namespaceRDF }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceUML:&emsp; </label>
                            <div> { this.state.equipmentVersion.namespaceUML }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.equipmentVersion.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquipmentVersionComponent
