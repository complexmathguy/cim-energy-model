import React, { Component } from 'react'
import LoadBreakSwitchService from '../services/LoadBreakSwitchService'

class ListLoadBreakSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadBreakSwitchs: []
        }
        this.addLoadBreakSwitch = this.addLoadBreakSwitch.bind(this);
        this.editLoadBreakSwitch = this.editLoadBreakSwitch.bind(this);
        this.deleteLoadBreakSwitch = this.deleteLoadBreakSwitch.bind(this);
    }

    deleteLoadBreakSwitch(id){
        LoadBreakSwitchService.deleteLoadBreakSwitch(id).then( res => {
            this.setState({loadBreakSwitchs: this.state.loadBreakSwitchs.filter(loadBreakSwitch => loadBreakSwitch.loadBreakSwitchId !== id)});
        });
    }
    viewLoadBreakSwitch(id){
        this.props.history.push(`/view-loadBreakSwitch/${id}`);
    }
    editLoadBreakSwitch(id){
        this.props.history.push(`/add-loadBreakSwitch/${id}`);
    }

    componentDidMount(){
        LoadBreakSwitchService.getLoadBreakSwitchs().then((res) => {
            this.setState({ loadBreakSwitchs: res.data});
        });
    }

    addLoadBreakSwitch(){
        this.props.history.push('/add-loadBreakSwitch/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadBreakSwitch List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadBreakSwitch}> Add LoadBreakSwitch</button>
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
                                    this.state.loadBreakSwitchs.map(
                                        loadBreakSwitch => 
                                        <tr key = {loadBreakSwitch.loadBreakSwitchId}>
                                             <td>
                                                 <button onClick={ () => this.editLoadBreakSwitch(loadBreakSwitch.loadBreakSwitchId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadBreakSwitch(loadBreakSwitch.loadBreakSwitchId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadBreakSwitch(loadBreakSwitch.loadBreakSwitchId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadBreakSwitchComponent
