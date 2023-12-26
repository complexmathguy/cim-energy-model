import React, { Component } from 'react'
import PowerSystemStabilizerDynamicsService from '../services/PowerSystemStabilizerDynamicsService';

class UpdatePowerSystemStabilizerDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePowerSystemStabilizerDynamics = this.updatePowerSystemStabilizerDynamics.bind(this);

    }

    componentDidMount(){
        PowerSystemStabilizerDynamicsService.getPowerSystemStabilizerDynamicsById(this.state.id).then( (res) =>{
            let powerSystemStabilizerDynamics = res.data;
            this.setState({
            });
        });
    }

    updatePowerSystemStabilizerDynamics = (e) => {
        e.preventDefault();
        let powerSystemStabilizerDynamics = {
            powerSystemStabilizerDynamicsId: this.state.id,
        };
        console.log('powerSystemStabilizerDynamics => ' + JSON.stringify(powerSystemStabilizerDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        PowerSystemStabilizerDynamicsService.updatePowerSystemStabilizerDynamics(powerSystemStabilizerDynamics).then( res => {
            this.props.history.push('/powerSystemStabilizerDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/powerSystemStabilizerDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PowerSystemStabilizerDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePowerSystemStabilizerDynamics}>Save</button>
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

export default UpdatePowerSystemStabilizerDynamicsComponent
