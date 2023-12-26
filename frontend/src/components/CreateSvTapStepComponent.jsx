import React, { Component } from 'react'
import SvTapStepService from '../services/SvTapStepService';

class CreateSvTapStepComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                position: ''
        }
        this.changepositionHandler = this.changepositionHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SvTapStepService.getSvTapStepById(this.state.id).then( (res) =>{
                let svTapStep = res.data;
                this.setState({
                    position: svTapStep.position
                });
            });
        }        
    }
    saveOrUpdateSvTapStep = (e) => {
        e.preventDefault();
        let svTapStep = {
                svTapStepId: this.state.id,
                position: this.state.position
            };
        console.log('svTapStep => ' + JSON.stringify(svTapStep));

        // step 5
        if(this.state.id === '_add'){
            svTapStep.svTapStepId=''
            SvTapStepService.createSvTapStep(svTapStep).then(res =>{
                this.props.history.push('/svTapSteps');
            });
        }else{
            SvTapStepService.updateSvTapStep(svTapStep).then( res => {
                this.props.history.push('/svTapSteps');
            });
        }
    }
    
    changepositionHandler= (event) => {
        this.setState({position: event.target.value});
    }

    cancel(){
        this.props.history.push('/svTapSteps');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvTapStep</h3>
        }else{
            return <h3 className="text-center">Update SvTapStep</h3>
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
                                            <label> position: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvTapStep}>Save</button>
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

export default CreateSvTapStepComponent
