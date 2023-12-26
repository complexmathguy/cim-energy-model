import React, { Component } from 'react'
import EquipmentService from '../services/EquipmentService';

class UpdateEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquipment = this.updateEquipment.bind(this);

    }

    componentDidMount(){
        EquipmentService.getEquipmentById(this.state.id).then( (res) =>{
            let equipment = res.data;
            this.setState({
            });
        });
    }

    updateEquipment = (e) => {
        e.preventDefault();
        let equipment = {
            equipmentId: this.state.id,
        };
        console.log('equipment => ' + JSON.stringify(equipment));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquipmentService.updateEquipment(equipment).then( res => {
            this.props.history.push('/equipments');
        });
    }


    cancel(){
        this.props.history.push('/equipments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Equipment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquipment}>Save</button>
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

export default UpdateEquipmentComponent
