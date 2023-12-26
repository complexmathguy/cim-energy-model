import React, { Component } from 'react'
import CommandService from '../services/CommandService'

class ListCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                commands: []
        }
        this.addCommand = this.addCommand.bind(this);
        this.editCommand = this.editCommand.bind(this);
        this.deleteCommand = this.deleteCommand.bind(this);
    }

    deleteCommand(id){
        CommandService.deleteCommand(id).then( res => {
            this.setState({commands: this.state.commands.filter(command => command.commandId !== id)});
        });
    }
    viewCommand(id){
        this.props.history.push(`/view-command/${id}`);
    }
    editCommand(id){
        this.props.history.push(`/add-command/${id}`);
    }

    componentDidMount(){
        CommandService.getCommands().then((res) => {
            this.setState({ commands: res.data});
        });
    }

    addCommand(){
        this.props.history.push('/add-command/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Command List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCommand}> Add Command</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> NormalValue </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.commands.map(
                                        command => 
                                        <tr key = {command.commandId}>
                                             <td> { command.normalValue } </td>
                                             <td> { command.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editCommand(command.commandId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCommand(command.commandId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCommand(command.commandId)} className="btn btn-info btn-sm">View </button>
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

export default ListCommandComponent
