import React, { Component } from 'react'
import ProprietaryParameterDynamicsService from '../services/ProprietaryParameterDynamicsService';

class UpdateProprietaryParameterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                booleanParameterValue: '',
                floatParameterValue: '',
                integerParameterValue: '',
                parameterNumber: ''
        }
        this.updateProprietaryParameterDynamics = this.updateProprietaryParameterDynamics.bind(this);

        this.changebooleanParameterValueHandler = this.changebooleanParameterValueHandler.bind(this);
        this.changefloatParameterValueHandler = this.changefloatParameterValueHandler.bind(this);
        this.changeintegerParameterValueHandler = this.changeintegerParameterValueHandler.bind(this);
        this.changeparameterNumberHandler = this.changeparameterNumberHandler.bind(this);
    }

    componentDidMount(){
        ProprietaryParameterDynamicsService.getProprietaryParameterDynamicsById(this.state.id).then( (res) =>{
            let proprietaryParameterDynamics = res.data;
            this.setState({
                booleanParameterValue: proprietaryParameterDynamics.booleanParameterValue,
                floatParameterValue: proprietaryParameterDynamics.floatParameterValue,
                integerParameterValue: proprietaryParameterDynamics.integerParameterValue,
                parameterNumber: proprietaryParameterDynamics.parameterNumber
            });
        });
    }

    updateProprietaryParameterDynamics = (e) => {
        e.preventDefault();
        let proprietaryParameterDynamics = {
            proprietaryParameterDynamicsId: this.state.id,
            booleanParameterValue: this.state.booleanParameterValue,
            floatParameterValue: this.state.floatParameterValue,
            integerParameterValue: this.state.integerParameterValue,
            parameterNumber: this.state.parameterNumber
        };
        console.log('proprietaryParameterDynamics => ' + JSON.stringify(proprietaryParameterDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        ProprietaryParameterDynamicsService.updateProprietaryParameterDynamics(proprietaryParameterDynamics).then( res => {
            this.props.history.push('/proprietaryParameterDynamicss');
        });
    }

    changebooleanParameterValueHandler= (event) => {
        this.setState({booleanParameterValue: event.target.value});
    }
    changefloatParameterValueHandler= (event) => {
        this.setState({floatParameterValue: event.target.value});
    }
    changeintegerParameterValueHandler= (event) => {
        this.setState({integerParameterValue: event.target.value});
    }
    changeparameterNumberHandler= (event) => {
        this.setState({parameterNumber: event.target.value});
    }

    cancel(){
        this.props.history.push('/proprietaryParameterDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ProprietaryParameterDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> booleanParameterValue: </label>
                                            #formFields( $attribute, 'update')
                                            <label> floatParameterValue: </label>
                                            #formFields( $attribute, 'update')
                                            <label> integerParameterValue: </label>
                                            #formFields( $attribute, 'update')
                                            <label> parameterNumber: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateProprietaryParameterDynamics}>Save</button>
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

export default UpdateProprietaryParameterDynamicsComponent
