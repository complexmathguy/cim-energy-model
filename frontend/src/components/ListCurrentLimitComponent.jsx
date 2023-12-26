import React, { Component } from 'react'
import CurrentLimitService from '../services/CurrentLimitService'

class ListCurrentLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                currentLimits: []
        }
        this.addCurrentLimit = this.addCurrentLimit.bind(this);
        this.editCurrentLimit = this.editCurrentLimit.bind(this);
        this.deleteCurrentLimit = this.deleteCurrentLimit.bind(this);
    }

    deleteCurrentLimit(id){
        CurrentLimitService.deleteCurrentLimit(id).then( res => {
            this.setState({currentLimits: this.state.currentLimits.filter(currentLimit => currentLimit.currentLimitId !== id)});
        });
    }
    viewCurrentLimit(id){
        this.props.history.push(`/view-currentLimit/${id}`);
    }
    editCurrentLimit(id){
        this.props.history.push(`/add-currentLimit/${id}`);
    }

    componentDidMount(){
        CurrentLimitService.getCurrentLimits().then((res) => {
            this.setState({ currentLimits: res.data});
        });
    }

    addCurrentLimit(){
        this.props.history.push('/add-currentLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">CurrentLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCurrentLimit}> Add CurrentLimit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.currentLimits.map(
                                        currentLimit => 
                                        <tr key = {currentLimit.currentLimitId}>
                                             <td> { currentLimit.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editCurrentLimit(currentLimit.currentLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCurrentLimit(currentLimit.currentLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCurrentLimit(currentLimit.currentLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListCurrentLimitComponent
