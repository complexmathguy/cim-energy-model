import React, { Component } from 'react'
import EquivalentEquipmentService from '../services/EquivalentEquipmentService';

class UpdateEquivalentEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquivalentEquipment = this.updateEquivalentEquipment.bind(this);

    }

    componentDidMount(){
        EquivalentEquipmentService.getEquivalentEquipmentById(this.state.id).then( (res) =>{
            let equivalentEquipment = res.data;
            this.setState({
            });
        });
    }

    updateEquivalentEquipment = (e) => {
        e.preventDefault();
        let equivalentEquipment = {
            equivalentEquipmentId: this.state.id,
        };
        console.log('equivalentEquipment => ' + JSON.stringify(equivalentEquipment));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentEquipmentService.updateEquivalentEquipment(equivalentEquipment).then( res => {
            this.props.history.push('/equivalentEquipments');
        });
    }


    cancel(){
        this.props.history.push('/equivalentEquipments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentEquipment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentEquipment}>Save</button>
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

export default UpdateEquivalentEquipmentComponent
