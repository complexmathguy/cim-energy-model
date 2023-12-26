import React, { Component } from 'react'
import ExcAVR5Service from '../services/ExcAVR5Service'

class ListExcAVR5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR5s: []
        }
        this.addExcAVR5 = this.addExcAVR5.bind(this);
        this.editExcAVR5 = this.editExcAVR5.bind(this);
        this.deleteExcAVR5 = this.deleteExcAVR5.bind(this);
    }

    deleteExcAVR5(id){
        ExcAVR5Service.deleteExcAVR5(id).then( res => {
            this.setState({excAVR5s: this.state.excAVR5s.filter(excAVR5 => excAVR5.excAVR5Id !== id)});
        });
    }
    viewExcAVR5(id){
        this.props.history.push(`/view-excAVR5/${id}`);
    }
    editExcAVR5(id){
        this.props.history.push(`/add-excAVR5/${id}`);
    }

    componentDidMount(){
        ExcAVR5Service.getExcAVR5s().then((res) => {
            this.setState({ excAVR5s: res.data});
        });
    }

    addExcAVR5(){
        this.props.history.push('/add-excAVR5/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR5 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR5}> Add ExcAVR5</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Rex </th>
                                    <th> Ta </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAVR5s.map(
                                        excAVR5 => 
                                        <tr key = {excAVR5.excAVR5Id}>
                                             <td> { excAVR5.ka } </td>
                                             <td> { excAVR5.rex } </td>
                                             <td> { excAVR5.ta } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR5(excAVR5.excAVR5Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR5(excAVR5.excAVR5Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR5(excAVR5.excAVR5Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR5Component
