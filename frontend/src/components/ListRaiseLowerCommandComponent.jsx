import React, { Component } from 'react'
import RaiseLowerCommandService from '../services/RaiseLowerCommandService'

class ListRaiseLowerCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                raiseLowerCommands: []
        }
        this.addRaiseLowerCommand = this.addRaiseLowerCommand.bind(this);
        this.editRaiseLowerCommand = this.editRaiseLowerCommand.bind(this);
        this.deleteRaiseLowerCommand = this.deleteRaiseLowerCommand.bind(this);
    }

    deleteRaiseLowerCommand(id){
        RaiseLowerCommandService.deleteRaiseLowerCommand(id).then( res => {
            this.setState({raiseLowerCommands: this.state.raiseLowerCommands.filter(raiseLowerCommand => raiseLowerCommand.raiseLowerCommandId !== id)});
        });
    }
    viewRaiseLowerCommand(id){
        this.props.history.push(`/view-raiseLowerCommand/${id}`);
    }
    editRaiseLowerCommand(id){
        this.props.history.push(`/add-raiseLowerCommand/${id}`);
    }

    componentDidMount(){
        RaiseLowerCommandService.getRaiseLowerCommands().then((res) => {
            this.setState({ raiseLowerCommands: res.data});
        });
    }

    addRaiseLowerCommand(){
        this.props.history.push('/add-raiseLowerCommand/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RaiseLowerCommand List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRaiseLowerCommand}> Add RaiseLowerCommand</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.raiseLowerCommands.map(
                                        raiseLowerCommand => 
                                        <tr key = {raiseLowerCommand.raiseLowerCommandId}>
                                             <td>
                                                 <button onClick={ () => this.editRaiseLowerCommand(raiseLowerCommand.raiseLowerCommandId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRaiseLowerCommand(raiseLowerCommand.raiseLowerCommandId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRaiseLowerCommand(raiseLowerCommand.raiseLowerCommandId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListRaiseLowerCommandComponent
