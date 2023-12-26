import React, { Component } from 'react'
import DynamicsFunctionBlockService from '../services/DynamicsFunctionBlockService'

class ListDynamicsFunctionBlockComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dynamicsFunctionBlocks: []
        }
        this.addDynamicsFunctionBlock = this.addDynamicsFunctionBlock.bind(this);
        this.editDynamicsFunctionBlock = this.editDynamicsFunctionBlock.bind(this);
        this.deleteDynamicsFunctionBlock = this.deleteDynamicsFunctionBlock.bind(this);
    }

    deleteDynamicsFunctionBlock(id){
        DynamicsFunctionBlockService.deleteDynamicsFunctionBlock(id).then( res => {
            this.setState({dynamicsFunctionBlocks: this.state.dynamicsFunctionBlocks.filter(dynamicsFunctionBlock => dynamicsFunctionBlock.dynamicsFunctionBlockId !== id)});
        });
    }
    viewDynamicsFunctionBlock(id){
        this.props.history.push(`/view-dynamicsFunctionBlock/${id}`);
    }
    editDynamicsFunctionBlock(id){
        this.props.history.push(`/add-dynamicsFunctionBlock/${id}`);
    }

    componentDidMount(){
        DynamicsFunctionBlockService.getDynamicsFunctionBlocks().then((res) => {
            this.setState({ dynamicsFunctionBlocks: res.data});
        });
    }

    addDynamicsFunctionBlock(){
        this.props.history.push('/add-dynamicsFunctionBlock/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DynamicsFunctionBlock List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDynamicsFunctionBlock}> Add DynamicsFunctionBlock</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Enabled </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dynamicsFunctionBlocks.map(
                                        dynamicsFunctionBlock => 
                                        <tr key = {dynamicsFunctionBlock.dynamicsFunctionBlockId}>
                                             <td> { dynamicsFunctionBlock.enabled } </td>
                                             <td>
                                                 <button onClick={ () => this.editDynamicsFunctionBlock(dynamicsFunctionBlock.dynamicsFunctionBlockId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDynamicsFunctionBlock(dynamicsFunctionBlock.dynamicsFunctionBlockId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDynamicsFunctionBlock(dynamicsFunctionBlock.dynamicsFunctionBlockId)} className="btn btn-info btn-sm">View </button>
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

export default ListDynamicsFunctionBlockComponent
