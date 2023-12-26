import React, { Component } from 'react'
import PFVArControllerType1UserDefinedService from '../services/PFVArControllerType1UserDefinedService';

class CreatePFVArControllerType1UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PFVArControllerType1UserDefinedService.getPFVArControllerType1UserDefinedById(this.state.id).then( (res) =>{
                let pFVArControllerType1UserDefined = res.data;
                this.setState({
                    proprietary: pFVArControllerType1UserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdatePFVArControllerType1UserDefined = (e) => {
        e.preventDefault();
        let pFVArControllerType1UserDefined = {
                pFVArControllerType1UserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('pFVArControllerType1UserDefined => ' + JSON.stringify(pFVArControllerType1UserDefined));

        // step 5
        if(this.state.id === '_add'){
            pFVArControllerType1UserDefined.pFVArControllerType1UserDefinedId=''
            PFVArControllerType1UserDefinedService.createPFVArControllerType1UserDefined(pFVArControllerType1UserDefined).then(res =>{
                this.props.history.push('/pFVArControllerType1UserDefineds');
            });
        }else{
            PFVArControllerType1UserDefinedService.updatePFVArControllerType1UserDefined(pFVArControllerType1UserDefined).then( res => {
                this.props.history.push('/pFVArControllerType1UserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArControllerType1UserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArControllerType1UserDefined</h3>
        }else{
            return <h3 className="text-center">Update PFVArControllerType1UserDefined</h3>
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
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArControllerType1UserDefined}>Save</button>
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

export default CreatePFVArControllerType1UserDefinedComponent
