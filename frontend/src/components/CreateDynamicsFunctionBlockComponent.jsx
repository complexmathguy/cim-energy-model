import React, { Component } from 'react'
import DynamicsFunctionBlockService from '../services/DynamicsFunctionBlockService';

class CreateDynamicsFunctionBlockComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                enabled: ''
        }
        this.changeenabledHandler = this.changeenabledHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DynamicsFunctionBlockService.getDynamicsFunctionBlockById(this.state.id).then( (res) =>{
                let dynamicsFunctionBlock = res.data;
                this.setState({
                    enabled: dynamicsFunctionBlock.enabled
                });
            });
        }        
    }
    saveOrUpdateDynamicsFunctionBlock = (e) => {
        e.preventDefault();
        let dynamicsFunctionBlock = {
                dynamicsFunctionBlockId: this.state.id,
                enabled: this.state.enabled
            };
        console.log('dynamicsFunctionBlock => ' + JSON.stringify(dynamicsFunctionBlock));

        // step 5
        if(this.state.id === '_add'){
            dynamicsFunctionBlock.dynamicsFunctionBlockId=''
            DynamicsFunctionBlockService.createDynamicsFunctionBlock(dynamicsFunctionBlock).then(res =>{
                this.props.history.push('/dynamicsFunctionBlocks');
            });
        }else{
            DynamicsFunctionBlockService.updateDynamicsFunctionBlock(dynamicsFunctionBlock).then( res => {
                this.props.history.push('/dynamicsFunctionBlocks');
            });
        }
    }
    
    changeenabledHandler= (event) => {
        this.setState({enabled: event.target.value});
    }

    cancel(){
        this.props.history.push('/dynamicsFunctionBlocks');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DynamicsFunctionBlock</h3>
        }else{
            return <h3 className="text-center">Update DynamicsFunctionBlock</h3>
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
                                            <label> enabled: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDynamicsFunctionBlock}>Save</button>
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

export default CreateDynamicsFunctionBlockComponent
