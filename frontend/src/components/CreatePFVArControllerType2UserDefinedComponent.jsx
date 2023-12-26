import React, { Component } from 'react'
import PFVArControllerType2UserDefinedService from '../services/PFVArControllerType2UserDefinedService';

class CreatePFVArControllerType2UserDefinedComponent extends Component {
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
            PFVArControllerType2UserDefinedService.getPFVArControllerType2UserDefinedById(this.state.id).then( (res) =>{
                let pFVArControllerType2UserDefined = res.data;
                this.setState({
                    proprietary: pFVArControllerType2UserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdatePFVArControllerType2UserDefined = (e) => {
        e.preventDefault();
        let pFVArControllerType2UserDefined = {
                pFVArControllerType2UserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('pFVArControllerType2UserDefined => ' + JSON.stringify(pFVArControllerType2UserDefined));

        // step 5
        if(this.state.id === '_add'){
            pFVArControllerType2UserDefined.pFVArControllerType2UserDefinedId=''
            PFVArControllerType2UserDefinedService.createPFVArControllerType2UserDefined(pFVArControllerType2UserDefined).then(res =>{
                this.props.history.push('/pFVArControllerType2UserDefineds');
            });
        }else{
            PFVArControllerType2UserDefinedService.updatePFVArControllerType2UserDefined(pFVArControllerType2UserDefined).then( res => {
                this.props.history.push('/pFVArControllerType2UserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArControllerType2UserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArControllerType2UserDefined</h3>
        }else{
            return <h3 className="text-center">Update PFVArControllerType2UserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArControllerType2UserDefined}>Save</button>
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

export default CreatePFVArControllerType2UserDefinedComponent
