import React, { Component } from 'react'
import MechanicalLoadDynamicsService from '../services/MechanicalLoadDynamicsService';

class UpdateMechanicalLoadDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMechanicalLoadDynamics = this.updateMechanicalLoadDynamics.bind(this);

    }

    componentDidMount(){
        MechanicalLoadDynamicsService.getMechanicalLoadDynamicsById(this.state.id).then( (res) =>{
            let mechanicalLoadDynamics = res.data;
            this.setState({
            });
        });
    }

    updateMechanicalLoadDynamics = (e) => {
        e.preventDefault();
        let mechanicalLoadDynamics = {
            mechanicalLoadDynamicsId: this.state.id,
        };
        console.log('mechanicalLoadDynamics => ' + JSON.stringify(mechanicalLoadDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        MechanicalLoadDynamicsService.updateMechanicalLoadDynamics(mechanicalLoadDynamics).then( res => {
            this.props.history.push('/mechanicalLoadDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/mechanicalLoadDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MechanicalLoadDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMechanicalLoadDynamics}>Save</button>
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

export default UpdateMechanicalLoadDynamicsComponent
