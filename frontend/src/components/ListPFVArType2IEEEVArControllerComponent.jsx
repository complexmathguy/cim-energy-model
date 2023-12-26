import React, { Component } from 'react'
import PFVArType2IEEEVArControllerService from '../services/PFVArType2IEEEVArControllerService'

class ListPFVArType2IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArType2IEEEVArControllers: []
        }
        this.addPFVArType2IEEEVArController = this.addPFVArType2IEEEVArController.bind(this);
        this.editPFVArType2IEEEVArController = this.editPFVArType2IEEEVArController.bind(this);
        this.deletePFVArType2IEEEVArController = this.deletePFVArType2IEEEVArController.bind(this);
    }

    deletePFVArType2IEEEVArController(id){
        PFVArType2IEEEVArControllerService.deletePFVArType2IEEEVArController(id).then( res => {
            this.setState({pFVArType2IEEEVArControllers: this.state.pFVArType2IEEEVArControllers.filter(pFVArType2IEEEVArController => pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId !== id)});
        });
    }
    viewPFVArType2IEEEVArController(id){
        this.props.history.push(`/view-pFVArType2IEEEVArController/${id}`);
    }
    editPFVArType2IEEEVArController(id){
        this.props.history.push(`/add-pFVArType2IEEEVArController/${id}`);
    }

    componentDidMount(){
        PFVArType2IEEEVArControllerService.getPFVArType2IEEEVArControllers().then((res) => {
            this.setState({ pFVArType2IEEEVArControllers: res.data});
        });
    }

    addPFVArType2IEEEVArController(){
        this.props.history.push('/add-pFVArType2IEEEVArController/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArType2IEEEVArController List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArType2IEEEVArController}> Add PFVArType2IEEEVArController</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Exlon </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Qref </th>
                                    <th> Vclmt </th>
                                    <th> Vref </th>
                                    <th> Vs </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pFVArType2IEEEVArControllers.map(
                                        pFVArType2IEEEVArController => 
                                        <tr key = {pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId}>
                                             <td> { pFVArType2IEEEVArController.exlon } </td>
                                             <td> { pFVArType2IEEEVArController.ki } </td>
                                             <td> { pFVArType2IEEEVArController.kp } </td>
                                             <td> { pFVArType2IEEEVArController.qref } </td>
                                             <td> { pFVArType2IEEEVArController.vclmt } </td>
                                             <td> { pFVArType2IEEEVArController.vref } </td>
                                             <td> { pFVArType2IEEEVArController.vs } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArType2IEEEVArController(pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArType2IEEEVArController(pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArType2IEEEVArController(pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArType2IEEEVArControllerComponent
