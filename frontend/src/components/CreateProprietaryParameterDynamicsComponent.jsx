import React, { Component } from 'react'
import ProprietaryParameterDynamicsService from '../services/ProprietaryParameterDynamicsService';

class CreateProprietaryParameterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                booleanParameterValue: '',
                floatParameterValue: '',
                integerParameterValue: '',
                parameterNumber: ''
        }
        this.changebooleanParameterValueHandler = this.changebooleanParameterValueHandler.bind(this);
        this.changefloatParameterValueHandler = this.changefloatParameterValueHandler.bind(this);
        this.changeintegerParameterValueHandler = this.changeintegerParameterValueHandler.bind(this);
        this.changeparameterNumberHandler = this.changeparameterNumberHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateProprietaryParameterDynamics = (e) => {
        e.preventDefault();
        let proprietaryParameterDynamics = {
                proprietaryParameterDynamicsId: this.state.id,
                booleanParameterValue: this.state.booleanParameterValue,
                floatParameterValue: this.state.floatParameterValue,
                integerParameterValue: this.state.integerParameterValue,
                parameterNumber: this.state.parameterNumber
            };
        console.log('proprietaryParameterDynamics => ' + JSON.stringify(proprietaryParameterDynamics));

        // step 5
        if(this.state.id === '_add'){
            proprietaryParameterDynamics.proprietaryParameterDynamicsId=''
            ProprietaryParameterDynamicsService.createProprietaryParameterDynamics(proprietaryParameterDynamics).then(res =>{
                this.props.history.push('/proprietaryParameterDynamicss');
            });
        }else{
            ProprietaryParameterDynamicsService.updateProprietaryParameterDynamics(proprietaryParameterDynamics).then( res => {
                this.props.history.push('/proprietaryParameterDynamicss');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ProprietaryParameterDynamics</h3>
        }else{
            return <h3 className="text-center">Update ProprietaryParameterDynamics</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> booleanParameterValue: </label>
                                            #formFields( $attribute, 'create')
                                            <label> floatParameterValue: </label>
                                            #formFields( $attribute, 'create')
                                            <label> integerParameterValue: </label>
                                            #formFields( $attribute, 'create')
                                            <label> parameterNumber: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateProprietaryParameterDynamics}>Save</button>
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

export default CreateProprietaryParameterDynamicsComponent
