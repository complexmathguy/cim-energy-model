import React, { Component } from 'react'
import RaiseLowerCommandService from '../services/RaiseLowerCommandService';

class UpdateRaiseLowerCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRaiseLowerCommand = this.updateRaiseLowerCommand.bind(this);

    }

    componentDidMount(){
        RaiseLowerCommandService.getRaiseLowerCommandById(this.state.id).then( (res) =>{
            let raiseLowerCommand = res.data;
            this.setState({
            });
        });
    }

    updateRaiseLowerCommand = (e) => {
        e.preventDefault();
        let raiseLowerCommand = {
            raiseLowerCommandId: this.state.id,
        };
        console.log('raiseLowerCommand => ' + JSON.stringify(raiseLowerCommand));
        console.log('id => ' + JSON.stringify(this.state.id));
        RaiseLowerCommandService.updateRaiseLowerCommand(raiseLowerCommand).then( res => {
            this.props.history.push('/raiseLowerCommands');
        });
    }


    cancel(){
        this.props.history.push('/raiseLowerCommands');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RaiseLowerCommand</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRaiseLowerCommand}>Save</button>
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

export default UpdateRaiseLowerCommandComponent
