import React, { Component } from 'react'
import OverexcitationLimiterUserDefinedService from '../services/OverexcitationLimiterUserDefinedService';

class UpdateOverexcitationLimiterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateOverexcitationLimiterUserDefined = this.updateOverexcitationLimiterUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        OverexcitationLimiterUserDefinedService.getOverexcitationLimiterUserDefinedById(this.state.id).then( (res) =>{
            let overexcitationLimiterUserDefined = res.data;
            this.setState({
                proprietary: overexcitationLimiterUserDefined.proprietary
            });
        });
    }

    updateOverexcitationLimiterUserDefined = (e) => {
        e.preventDefault();
        let overexcitationLimiterUserDefined = {
            overexcitationLimiterUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('overexcitationLimiterUserDefined => ' + JSON.stringify(overexcitationLimiterUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcitationLimiterUserDefinedService.updateOverexcitationLimiterUserDefined(overexcitationLimiterUserDefined).then( res => {
            this.props.history.push('/overexcitationLimiterUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/overexcitationLimiterUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcitationLimiterUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcitationLimiterUserDefined}>Save</button>
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

export default UpdateOverexcitationLimiterUserDefinedComponent
