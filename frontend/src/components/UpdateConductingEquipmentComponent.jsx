import React, { Component } from 'react'
import ConductingEquipmentService from '../services/ConductingEquipmentService';

class UpdateConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConductingEquipment = this.updateConductingEquipment.bind(this);

    }

    componentDidMount(){
        ConductingEquipmentService.getConductingEquipmentById(this.state.id).then( (res) =>{
            let conductingEquipment = res.data;
            this.setState({
            });
        });
    }

    updateConductingEquipment = (e) => {
        e.preventDefault();
        let conductingEquipment = {
            conductingEquipmentId: this.state.id,
        };
        console.log('conductingEquipment => ' + JSON.stringify(conductingEquipment));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConductingEquipmentService.updateConductingEquipment(conductingEquipment).then( res => {
            this.props.history.push('/conductingEquipments');
        });
    }


    cancel(){
        this.props.history.push('/conductingEquipments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConductingEquipment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConductingEquipment}>Save</button>
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

export default UpdateConductingEquipmentComponent
