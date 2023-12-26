import React, { Component } from 'react'
import DiscExcContIEEEDEC1AService from '../services/DiscExcContIEEEDEC1AService'

class ListDiscExcContIEEEDEC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discExcContIEEEDEC1As: []
        }
        this.addDiscExcContIEEEDEC1A = this.addDiscExcContIEEEDEC1A.bind(this);
        this.editDiscExcContIEEEDEC1A = this.editDiscExcContIEEEDEC1A.bind(this);
        this.deleteDiscExcContIEEEDEC1A = this.deleteDiscExcContIEEEDEC1A.bind(this);
    }

    deleteDiscExcContIEEEDEC1A(id){
        DiscExcContIEEEDEC1AService.deleteDiscExcContIEEEDEC1A(id).then( res => {
            this.setState({discExcContIEEEDEC1As: this.state.discExcContIEEEDEC1As.filter(discExcContIEEEDEC1A => discExcContIEEEDEC1A.discExcContIEEEDEC1AId !== id)});
        });
    }
    viewDiscExcContIEEEDEC1A(id){
        this.props.history.push(`/view-discExcContIEEEDEC1A/${id}`);
    }
    editDiscExcContIEEEDEC1A(id){
        this.props.history.push(`/add-discExcContIEEEDEC1A/${id}`);
    }

    componentDidMount(){
        DiscExcContIEEEDEC1AService.getDiscExcContIEEEDEC1As().then((res) => {
            this.setState({ discExcContIEEEDEC1As: res.data});
        });
    }

    addDiscExcContIEEEDEC1A(){
        this.props.history.push('/add-discExcContIEEEDEC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscExcContIEEEDEC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscExcContIEEEDEC1A}> Add DiscExcContIEEEDEC1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Esc </th>
                                    <th> Kan </th>
                                    <th> Ketl </th>
                                    <th> Tan </th>
                                    <th> Td </th>
                                    <th> Tl1 </th>
                                    <th> Tl2 </th>
                                    <th> Tw5 </th>
                                    <th> Value </th>
                                    <th> Vanmax </th>
                                    <th> Vomax </th>
                                    <th> Vomin </th>
                                    <th> Vsmax </th>
                                    <th> Vsmin </th>
                                    <th> Vtc </th>
                                    <th> Vtlmt </th>
                                    <th> Vtm </th>
                                    <th> Vtn </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.discExcContIEEEDEC1As.map(
                                        discExcContIEEEDEC1A => 
                                        <tr key = {discExcContIEEEDEC1A.discExcContIEEEDEC1AId}>
                                             <td> { discExcContIEEEDEC1A.esc } </td>
                                             <td> { discExcContIEEEDEC1A.kan } </td>
                                             <td> { discExcContIEEEDEC1A.ketl } </td>
                                             <td> { discExcContIEEEDEC1A.tan } </td>
                                             <td> { discExcContIEEEDEC1A.td } </td>
                                             <td> { discExcContIEEEDEC1A.tl1 } </td>
                                             <td> { discExcContIEEEDEC1A.tl2 } </td>
                                             <td> { discExcContIEEEDEC1A.tw5 } </td>
                                             <td> { discExcContIEEEDEC1A.value } </td>
                                             <td> { discExcContIEEEDEC1A.vanmax } </td>
                                             <td> { discExcContIEEEDEC1A.vomax } </td>
                                             <td> { discExcContIEEEDEC1A.vomin } </td>
                                             <td> { discExcContIEEEDEC1A.vsmax } </td>
                                             <td> { discExcContIEEEDEC1A.vsmin } </td>
                                             <td> { discExcContIEEEDEC1A.vtc } </td>
                                             <td> { discExcContIEEEDEC1A.vtlmt } </td>
                                             <td> { discExcContIEEEDEC1A.vtm } </td>
                                             <td> { discExcContIEEEDEC1A.vtn } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiscExcContIEEEDEC1A(discExcContIEEEDEC1A.discExcContIEEEDEC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscExcContIEEEDEC1A(discExcContIEEEDEC1A.discExcContIEEEDEC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscExcContIEEEDEC1A(discExcContIEEEDEC1A.discExcContIEEEDEC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscExcContIEEEDEC1AComponent
