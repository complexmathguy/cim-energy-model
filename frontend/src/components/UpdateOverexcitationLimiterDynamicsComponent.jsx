import React, { Component } from 'react'
import OverexcitationLimiterDynamicsService from '../services/OverexcitationLimiterDynamicsService';

class UpdateOverexcitationLimiterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOverexcitationLimiterDynamics = this.updateOverexcitationLimiterDynamics.bind(this);

    }

    componentDidMount(){
        OverexcitationLimiterDynamicsService.getOverexcitationLimiterDynamicsById(this.state.id).then( (res) =>{
            let overexcitationLimiterDynamics = res.data;
            this.setState({
            });
        });
    }

    updateOverexcitationLimiterDynamics = (e) => {
        e.preventDefault();
        let overexcitationLimiterDynamics = {
            overexcitationLimiterDynamicsId: this.state.id,
        };
        console.log('overexcitationLimiterDynamics => ' + JSON.stringify(overexcitationLimiterDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcitationLimiterDynamicsService.updateOverexcitationLimiterDynamics(overexcitationLimiterDynamics).then( res => {
            this.props.history.push('/overexcitationLimiterDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/overexcitationLimiterDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcitationLimiterDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcitationLimiterDynamics}>Save</button>
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

export default UpdateOverexcitationLimiterDynamicsComponent
