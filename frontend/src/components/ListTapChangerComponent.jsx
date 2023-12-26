import React, { Component } from 'react'
import TapChangerService from '../services/TapChangerService'

class ListTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                tapChangers: []
        }
        this.addTapChanger = this.addTapChanger.bind(this);
        this.editTapChanger = this.editTapChanger.bind(this);
        this.deleteTapChanger = this.deleteTapChanger.bind(this);
    }

    deleteTapChanger(id){
        TapChangerService.deleteTapChanger(id).then( res => {
            this.setState({tapChangers: this.state.tapChangers.filter(tapChanger => tapChanger.tapChangerId !== id)});
        });
    }
    viewTapChanger(id){
        this.props.history.push(`/view-tapChanger/${id}`);
    }
    editTapChanger(id){
        this.props.history.push(`/add-tapChanger/${id}`);
    }

    componentDidMount(){
        TapChangerService.getTapChangers().then((res) => {
            this.setState({ tapChangers: res.data});
        });
    }

    addTapChanger(){
        this.props.history.push('/add-tapChanger/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TapChanger List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTapChanger}> Add TapChanger</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> HighStep </th>
                                    <th> LowStep </th>
                                    <th> LtcFlag </th>
                                    <th> NeutralStep </th>
                                    <th> NeutralU </th>
                                    <th> NormalStep </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.tapChangers.map(
                                        tapChanger => 
                                        <tr key = {tapChanger.tapChangerId}>
                                             <td> { tapChanger.highStep } </td>
                                             <td> { tapChanger.lowStep } </td>
                                             <td> { tapChanger.ltcFlag } </td>
                                             <td> { tapChanger.neutralStep } </td>
                                             <td> { tapChanger.neutralU } </td>
                                             <td> { tapChanger.normalStep } </td>
                                             <td>
                                                 <button onClick={ () => this.editTapChanger(tapChanger.tapChangerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTapChanger(tapChanger.tapChangerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTapChanger(tapChanger.tapChangerId)} className="btn btn-info btn-sm">View </button>
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

export default ListTapChangerComponent
