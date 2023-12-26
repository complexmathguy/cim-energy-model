import React, { Component } from 'react'
import PFVArType1IEEEVArControllerService from '../services/PFVArType1IEEEVArControllerService'

class ListPFVArType1IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArType1IEEEVArControllers: []
        }
        this.addPFVArType1IEEEVArController = this.addPFVArType1IEEEVArController.bind(this);
        this.editPFVArType1IEEEVArController = this.editPFVArType1IEEEVArController.bind(this);
        this.deletePFVArType1IEEEVArController = this.deletePFVArType1IEEEVArController.bind(this);
    }

    deletePFVArType1IEEEVArController(id){
        PFVArType1IEEEVArControllerService.deletePFVArType1IEEEVArController(id).then( res => {
            this.setState({pFVArType1IEEEVArControllers: this.state.pFVArType1IEEEVArControllers.filter(pFVArType1IEEEVArController => pFVArType1IEEEVArController.pFVArType1IEEEVArControllerId !== id)});
        });
    }
    viewPFVArType1IEEEVArController(id){
        this.props.history.push(`/view-pFVArType1IEEEVArController/${id}`);
    }
    editPFVArType1IEEEVArController(id){
        this.props.history.push(`/add-pFVArType1IEEEVArController/${id}`);
    }

    componentDidMount(){
        PFVArType1IEEEVArControllerService.getPFVArType1IEEEVArControllers().then((res) => {
            this.setState({ pFVArType1IEEEVArControllers: res.data});
        });
    }

    addPFVArType1IEEEVArController(){
        this.props.history.push('/add-pFVArType1IEEEVArController/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArType1IEEEVArController List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArType1IEEEVArController}> Add PFVArType1IEEEVArController</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Tvarc </th>
                                    <th> Vvar </th>
                                    <th> Vvarcbw </th>
                                    <th> Vvarref </th>
                                    <th> Vvtmax </th>
                                    <th> Vvtmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pFVArType1IEEEVArControllers.map(
                                        pFVArType1IEEEVArController => 
                                        <tr key = {pFVArType1IEEEVArController.pFVArType1IEEEVArControllerId}>
                                             <td> { pFVArType1IEEEVArController.tvarc } </td>
                                             <td> { pFVArType1IEEEVArController.vvar } </td>
                                             <td> { pFVArType1IEEEVArController.vvarcbw } </td>
                                             <td> { pFVArType1IEEEVArController.vvarref } </td>
                                             <td> { pFVArType1IEEEVArController.vvtmax } </td>
                                             <td> { pFVArType1IEEEVArController.vvtmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArType1IEEEVArController(pFVArType1IEEEVArController.pFVArType1IEEEVArControllerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArType1IEEEVArController(pFVArType1IEEEVArController.pFVArType1IEEEVArControllerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArType1IEEEVArController(pFVArType1IEEEVArController.pFVArType1IEEEVArControllerId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArType1IEEEVArControllerComponent
