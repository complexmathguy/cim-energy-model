import React, { Component } from 'react'
import SeasonService from '../services/SeasonService'

class ListSeasonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                seasons: []
        }
        this.addSeason = this.addSeason.bind(this);
        this.editSeason = this.editSeason.bind(this);
        this.deleteSeason = this.deleteSeason.bind(this);
    }

    deleteSeason(id){
        SeasonService.deleteSeason(id).then( res => {
            this.setState({seasons: this.state.seasons.filter(season => season.seasonId !== id)});
        });
    }
    viewSeason(id){
        this.props.history.push(`/view-season/${id}`);
    }
    editSeason(id){
        this.props.history.push(`/add-season/${id}`);
    }

    componentDidMount(){
        SeasonService.getSeasons().then((res) => {
            this.setState({ seasons: res.data});
        });
    }

    addSeason(){
        this.props.history.push('/add-season/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Season List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSeason}> Add Season</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> EndDate </th>
                                    <th> StartDate </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.seasons.map(
                                        season => 
                                        <tr key = {season.seasonId}>
                                             <td> { season.endDate } </td>
                                             <td> { season.startDate } </td>
                                             <td>
                                                 <button onClick={ () => this.editSeason(season.seasonId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSeason(season.seasonId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSeason(season.seasonId)} className="btn btn-info btn-sm">View </button>
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

export default ListSeasonComponent
