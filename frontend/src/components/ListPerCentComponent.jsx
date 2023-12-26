import React, { Component } from 'react'
import PerCentService from '../services/PerCentService'

class ListPerCentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                perCents: []
        }
        this.addPerCent = this.addPerCent.bind(this);
        this.editPerCent = this.editPerCent.bind(this);
        this.deletePerCent = this.deletePerCent.bind(this);
    }

    deletePerCent(id){
        PerCentService.deletePerCent(id).then( res => {
            this.setState({perCents: this.state.perCents.filter(perCent => perCent.perCentId !== id)});
        });
    }
    viewPerCent(id){
        this.props.history.push(`/view-perCent/${id}`);
    }
    editPerCent(id){
        this.props.history.push(`/add-perCent/${id}`);
    }

    componentDidMount(){
        PerCentService.getPerCents().then((res) => {
            this.setState({ perCents: res.data});
        });
    }

    addPerCent(){
        this.props.history.push('/add-perCent/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PerCent List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPerCent}> Add PerCent</button>
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
                                    this.state.perCents.map(
                                        perCent => 
                                        <tr key = {perCent.perCentId}>
                                             <td> { perCent.multiplier } </td>
                                             <td> { perCent.unit } </td>
                                             <td> { perCent.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editPerCent(perCent.perCentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePerCent(perCent.perCentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPerCent(perCent.perCentId)} className="btn btn-info btn-sm">View </button>
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

export default ListPerCentComponent
