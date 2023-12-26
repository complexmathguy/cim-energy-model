import React, { Component } from 'react'
import PFVArControllerType2DynamicsService from '../services/PFVArControllerType2DynamicsService';

class UpdatePFVArControllerType2DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePFVArControllerType2Dynamics = this.updatePFVArControllerType2Dynamics.bind(this);

    }

    componentDidMount(){
        PFVArControllerType2DynamicsService.getPFVArControllerType2DynamicsById(this.state.id).then( (res) =>{
            let pFVArControllerType2Dynamics = res.data;
            this.setState({
            });
        });
    }

    updatePFVArControllerType2Dynamics = (e) => {
        e.preventDefault();
        let pFVArControllerType2Dynamics = {
            pFVArControllerType2DynamicsId: this.state.id,
        };
        console.log('pFVArControllerType2Dynamics => ' + JSON.stringify(pFVArControllerType2Dynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArControllerType2DynamicsService.updatePFVArControllerType2Dynamics(pFVArControllerType2Dynamics).then( res => {
            this.props.history.push('/pFVArControllerType2Dynamicss');
        });
    }


    cancel(){
        this.props.history.push('/pFVArControllerType2Dynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArControllerType2Dynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArControllerType2Dynamics}>Save</button>
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

export default UpdatePFVArControllerType2DynamicsComponent
