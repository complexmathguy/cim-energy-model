import React, { Component } from 'react'
import TurbineLoadControllerDynamicsService from '../services/TurbineLoadControllerDynamicsService';

class UpdateTurbineLoadControllerDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTurbineLoadControllerDynamics = this.updateTurbineLoadControllerDynamics.bind(this);

    }

    componentDidMount(){
        TurbineLoadControllerDynamicsService.getTurbineLoadControllerDynamicsById(this.state.id).then( (res) =>{
            let turbineLoadControllerDynamics = res.data;
            this.setState({
            });
        });
    }

    updateTurbineLoadControllerDynamics = (e) => {
        e.preventDefault();
        let turbineLoadControllerDynamics = {
            turbineLoadControllerDynamicsId: this.state.id,
        };
        console.log('turbineLoadControllerDynamics => ' + JSON.stringify(turbineLoadControllerDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        TurbineLoadControllerDynamicsService.updateTurbineLoadControllerDynamics(turbineLoadControllerDynamics).then( res => {
            this.props.history.push('/turbineLoadControllerDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/turbineLoadControllerDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TurbineLoadControllerDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTurbineLoadControllerDynamics}>Save</button>
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

export default UpdateTurbineLoadControllerDynamicsComponent
