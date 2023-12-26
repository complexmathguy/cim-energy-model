import React, { Component } from 'react'
import GenICompensationForGenJService from '../services/GenICompensationForGenJService'

class ListGenICompensationForGenJComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                genICompensationForGenJs: []
        }
        this.addGenICompensationForGenJ = this.addGenICompensationForGenJ.bind(this);
        this.editGenICompensationForGenJ = this.editGenICompensationForGenJ.bind(this);
        this.deleteGenICompensationForGenJ = this.deleteGenICompensationForGenJ.bind(this);
    }

    deleteGenICompensationForGenJ(id){
        GenICompensationForGenJService.deleteGenICompensationForGenJ(id).then( res => {
            this.setState({genICompensationForGenJs: this.state.genICompensationForGenJs.filter(genICompensationForGenJ => genICompensationForGenJ.genICompensationForGenJId !== id)});
        });
    }
    viewGenICompensationForGenJ(id){
        this.props.history.push(`/view-genICompensationForGenJ/${id}`);
    }
    editGenICompensationForGenJ(id){
        this.props.history.push(`/add-genICompensationForGenJ/${id}`);
    }

    componentDidMount(){
        GenICompensationForGenJService.getGenICompensationForGenJs().then((res) => {
            this.setState({ genICompensationForGenJs: res.data});
        });
    }

    addGenICompensationForGenJ(){
        this.props.history.push('/add-genICompensationForGenJ/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GenICompensationForGenJ List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGenICompensationForGenJ}> Add GenICompensationForGenJ</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Rcij </th>
                                    <th> Xcij </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.genICompensationForGenJs.map(
                                        genICompensationForGenJ => 
                                        <tr key = {genICompensationForGenJ.genICompensationForGenJId}>
                                             <td> { genICompensationForGenJ.rcij } </td>
                                             <td> { genICompensationForGenJ.xcij } </td>
                                             <td>
                                                 <button onClick={ () => this.editGenICompensationForGenJ(genICompensationForGenJ.genICompensationForGenJId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGenICompensationForGenJ(genICompensationForGenJ.genICompensationForGenJId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGenICompensationForGenJ(genICompensationForGenJ.genICompensationForGenJId)} className="btn btn-info btn-sm">View </button>
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

export default ListGenICompensationForGenJComponent
