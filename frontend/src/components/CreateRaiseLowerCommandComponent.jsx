import React, { Component } from 'react'
import RaiseLowerCommandService from '../services/RaiseLowerCommandService';

class CreateRaiseLowerCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RaiseLowerCommandService.getRaiseLowerCommandById(this.state.id).then( (res) =>{
                let raiseLowerCommand = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRaiseLowerCommand = (e) => {
        e.preventDefault();
        let raiseLowerCommand = {
                raiseLowerCommandId: this.state.id,
            };
        console.log('raiseLowerCommand => ' + JSON.stringify(raiseLowerCommand));

        // step 5
        if(this.state.id === '_add'){
            raiseLowerCommand.raiseLowerCommandId=''
            RaiseLowerCommandService.createRaiseLowerCommand(raiseLowerCommand).then(res =>{
                this.props.history.push('/raiseLowerCommands');
            });
        }else{
            RaiseLowerCommandService.updateRaiseLowerCommand(raiseLowerCommand).then( res => {
                this.props.history.push('/raiseLowerCommands');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/raiseLowerCommands');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RaiseLowerCommand</h3>
        }else{
            return <h3 className="text-center">Update RaiseLowerCommand</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRaiseLowerCommand}>Save</button>
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

export default CreateRaiseLowerCommandComponent
