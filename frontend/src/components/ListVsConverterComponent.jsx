import React, { Component } from 'react'
import VsConverterService from '../services/VsConverterService'

class ListVsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                vsConverters: []
        }
        this.addVsConverter = this.addVsConverter.bind(this);
        this.editVsConverter = this.editVsConverter.bind(this);
        this.deleteVsConverter = this.deleteVsConverter.bind(this);
    }

    deleteVsConverter(id){
        VsConverterService.deleteVsConverter(id).then( res => {
            this.setState({vsConverters: this.state.vsConverters.filter(vsConverter => vsConverter.vsConverterId !== id)});
        });
    }
    viewVsConverter(id){
        this.props.history.push(`/view-vsConverter/${id}`);
    }
    editVsConverter(id){
        this.props.history.push(`/add-vsConverter/${id}`);
    }

    componentDidMount(){
        VsConverterService.getVsConverters().then((res) => {
            this.setState({ vsConverters: res.data});
        });
    }

    addVsConverter(){
        this.props.history.push('/add-vsConverter/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VsConverter List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVsConverter}> Add VsConverter</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> MaxModulationIndex </th>
                                    <th> MaxValveCurrent </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.vsConverters.map(
                                        vsConverter => 
                                        <tr key = {vsConverter.vsConverterId}>
                                             <td> { vsConverter.maxModulationIndex } </td>
                                             <td> { vsConverter.maxValveCurrent } </td>
                                             <td>
                                                 <button onClick={ () => this.editVsConverter(vsConverter.vsConverterId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVsConverter(vsConverter.vsConverterId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVsConverter(vsConverter.vsConverterId)} className="btn btn-info btn-sm">View </button>
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

export default ListVsConverterComponent
