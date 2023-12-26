import React, { Component } from 'react'
import TurbineGovernorDynamicsService from '../services/TurbineGovernorDynamicsService';

class UpdateTurbineGovernorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTurbineGovernorDynamics = this.updateTurbineGovernorDynamics.bind(this);

    }

    componentDidMount(){
        TurbineGovernorDynamicsService.getTurbineGovernorDynamicsById(this.state.id).then( (res) =>{
            let turbineGovernorDynamics = res.data;
            this.setState({
            });
        });
    }

    updateTurbineGovernorDynamics = (e) => {
        e.preventDefault();
        let turbineGovernorDynamics = {
            turbineGovernorDynamicsId: this.state.id,
        };
        console.log('turbineGovernorDynamics => ' + JSON.stringify(turbineGovernorDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        TurbineGovernorDynamicsService.updateTurbineGovernorDynamics(turbineGovernorDynamics).then( res => {
            this.props.history.push('/turbineGovernorDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/turbineGovernorDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TurbineGovernorDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTurbineGovernorDynamics}>Save</button>
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

export default UpdateTurbineGovernorDynamicsComponent
