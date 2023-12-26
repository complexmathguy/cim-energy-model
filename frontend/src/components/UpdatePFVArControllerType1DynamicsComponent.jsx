import React, { Component } from 'react'
import PFVArControllerType1DynamicsService from '../services/PFVArControllerType1DynamicsService';

class UpdatePFVArControllerType1DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePFVArControllerType1Dynamics = this.updatePFVArControllerType1Dynamics.bind(this);

    }

    componentDidMount(){
        PFVArControllerType1DynamicsService.getPFVArControllerType1DynamicsById(this.state.id).then( (res) =>{
            let pFVArControllerType1Dynamics = res.data;
            this.setState({
            });
        });
    }

    updatePFVArControllerType1Dynamics = (e) => {
        e.preventDefault();
        let pFVArControllerType1Dynamics = {
            pFVArControllerType1DynamicsId: this.state.id,
        };
        console.log('pFVArControllerType1Dynamics => ' + JSON.stringify(pFVArControllerType1Dynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArControllerType1DynamicsService.updatePFVArControllerType1Dynamics(pFVArControllerType1Dynamics).then( res => {
            this.props.history.push('/pFVArControllerType1Dynamicss');
        });
    }


    cancel(){
        this.props.history.push('/pFVArControllerType1Dynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArControllerType1Dynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArControllerType1Dynamics}>Save</button>
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

export default UpdatePFVArControllerType1DynamicsComponent
