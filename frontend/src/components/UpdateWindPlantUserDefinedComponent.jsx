import React, { Component } from 'react'
import WindPlantUserDefinedService from '../services/WindPlantUserDefinedService';

class UpdateWindPlantUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateWindPlantUserDefined = this.updateWindPlantUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        WindPlantUserDefinedService.getWindPlantUserDefinedById(this.state.id).then( (res) =>{
            let windPlantUserDefined = res.data;
            this.setState({
                proprietary: windPlantUserDefined.proprietary
            });
        });
    }

    updateWindPlantUserDefined = (e) => {
        e.preventDefault();
        let windPlantUserDefined = {
            windPlantUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('windPlantUserDefined => ' + JSON.stringify(windPlantUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantUserDefinedService.updateWindPlantUserDefined(windPlantUserDefined).then( res => {
            this.props.history.push('/windPlantUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/windPlantUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantUserDefined}>Save</button>
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

export default UpdateWindPlantUserDefinedComponent
