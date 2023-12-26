import React, { Component } from 'react'
import SecondsService from '../services/SecondsService'

class ListSecondsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                secondss: []
        }
        this.addSeconds = this.addSeconds.bind(this);
        this.editSeconds = this.editSeconds.bind(this);
        this.deleteSeconds = this.deleteSeconds.bind(this);
    }

    deleteSeconds(id){
        SecondsService.deleteSeconds(id).then( res => {
            this.setState({secondss: this.state.secondss.filter(seconds => seconds.secondsId !== id)});
        });
    }
    viewSeconds(id){
        this.props.history.push(`/view-seconds/${id}`);
    }
    editSeconds(id){
        this.props.history.push(`/add-seconds/${id}`);
    }

    componentDidMount(){
        SecondsService.getSecondss().then((res) => {
            this.setState({ secondss: res.data});
        });
    }

    addSeconds(){
        this.props.history.push('/add-seconds/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Seconds List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSeconds}> Add Seconds</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.secondss.map(
                                        seconds => 
                                        <tr key = {seconds.secondsId}>
                                             <td> { seconds.multiplier } </td>
                                             <td> { seconds.unit } </td>
                                             <td> { seconds.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editSeconds(seconds.secondsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSeconds(seconds.secondsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSeconds(seconds.secondsId)} className="btn btn-info btn-sm">View </button>
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

export default ListSecondsComponent
