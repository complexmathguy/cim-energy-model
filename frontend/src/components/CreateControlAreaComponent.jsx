import React, { Component } from 'react'
import ControlAreaService from '../services/ControlAreaService';

class CreateControlAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                type: ''
        }
        this.changetypeHandler = this.changetypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ControlAreaService.getControlAreaById(this.state.id).then( (res) =>{
                let controlArea = res.data;
                this.setState({
                    type: controlArea.type
                });
            });
        }        
    }
    saveOrUpdateControlArea = (e) => {
        e.preventDefault();
        let controlArea = {
                controlAreaId: this.state.id,
                type: this.state.type
            };
        console.log('controlArea => ' + JSON.stringify(controlArea));

        // step 5
        if(this.state.id === '_add'){
            controlArea.controlAreaId=''
            ControlAreaService.createControlArea(controlArea).then(res =>{
                this.props.history.push('/controlAreas');
            });
        }else{
            ControlAreaService.updateControlArea(controlArea).then( res => {
                this.props.history.push('/controlAreas');
            });
        }
    }
    
    changetypeHandler= (event) => {
        this.setState({type: event.target.value});
    }

    cancel(){
        this.props.history.push('/controlAreas');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ControlArea</h3>
        }else{
            return <h3 className="text-center">Update ControlArea</h3>
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
                                            <label> type: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateControlArea}>Save</button>
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

export default CreateControlAreaComponent
