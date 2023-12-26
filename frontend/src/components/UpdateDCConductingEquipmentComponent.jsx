import React, { Component } from 'react'
import DCConductingEquipmentService from '../services/DCConductingEquipmentService';

class UpdateDCConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCConductingEquipment = this.updateDCConductingEquipment.bind(this);

    }

    componentDidMount(){
        DCConductingEquipmentService.getDCConductingEquipmentById(this.state.id).then( (res) =>{
            let dCConductingEquipment = res.data;
            this.setState({
            });
        });
    }

    updateDCConductingEquipment = (e) => {
        e.preventDefault();
        let dCConductingEquipment = {
            dCConductingEquipmentId: this.state.id,
        };
        console.log('dCConductingEquipment => ' + JSON.stringify(dCConductingEquipment));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCConductingEquipmentService.updateDCConductingEquipment(dCConductingEquipment).then( res => {
            this.props.history.push('/dCConductingEquipments');
        });
    }


    cancel(){
        this.props.history.push('/dCConductingEquipments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCConductingEquipment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCConductingEquipment}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateDCConductingEquipmentComponent
