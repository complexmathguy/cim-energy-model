import React, { Component } from 'react'
import Simple_FloatService from '../services/Simple_FloatService'

class ListSimple_FloatComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                simple_Floats: []
        }
        this.addSimple_Float = this.addSimple_Float.bind(this);
        this.editSimple_Float = this.editSimple_Float.bind(this);
        this.deleteSimple_Float = this.deleteSimple_Float.bind(this);
    }

    deleteSimple_Float(id){
        Simple_FloatService.deleteSimple_Float(id).then( res => {
            this.setState({simple_Floats: this.state.simple_Floats.filter(simple_Float => simple_Float.simple_FloatId !== id)});
        });
    }
    viewSimple_Float(id){
        this.props.history.push(`/view-simple_Float/${id}`);
    }
    editSimple_Float(id){
        this.props.history.push(`/add-simple_Float/${id}`);
    }

    componentDidMount(){
        Simple_FloatService.getSimple_Floats().then((res) => {
            this.setState({ simple_Floats: res.data});
        });
    }

    addSimple_Float(){
        this.props.history.push('/add-simple_Float/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Simple_Float List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSimple_Float}> Add Simple_Float</button>
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
                                    this.state.simple_Floats.map(
                                        simple_Float => 
                                        <tr key = {simple_Float.simple_FloatId}>
                                             <td> { simple_Float.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editSimple_Float(simple_Float.simple_FloatId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSimple_Float(simple_Float.simple_FloatId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSimple_Float(simple_Float.simple_FloatId)} className="btn btn-info btn-sm">View </button>
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

export default ListSimple_FloatComponent
